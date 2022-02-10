import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as Highcharts from 'highcharts';
import { Graph } from '../Models/Graph.model';
import { DepartmentService } from '../Services/department.service';
declare var require: any;
const More = require('highcharts/highcharts-more');
More(Highcharts);

const drillDown = require('highcharts/modules/drilldown');
drillDown(Highcharts);

const Accessibility = require('highcharts/modules/accessibility');
Accessibility(Highcharts);

@Component({
  selector: 'app-high-charts',
  templateUrl: './high-charts.component.html',
  styleUrls: ['./high-charts.component.css'],
})
export class HighChartsComponent implements OnInit {
 seriesData: Graph[] = [];
 drillDownData:Graph[] = [];
  ngOnInit(): void {
    this.departmentService.getAllDepartments().subscribe((response) => {
      for (let k = 0; k < response.length; k++) {
        var randomNumber = Math.floor(Math.random() * 80 + 400);
        var seriesObject = {
          name: response[k].departmentName,
          y: randomNumber,
          drilldown: response[k].departmentName,
        };
        var drillDownObject = {
          name: response[k].departmentName,
          id:response[k].departmentName,
          stack:response[k].departmentName,
          data:[5,6,7,8,9]
        };
        this.seriesData.push(seriesObject)
        this.drillDownData.push(drillDownObject);
       
      }
      this.options.series[0]['data'] = this.seriesData;
      this.options.drilldown.series = this.drillDownData;
      Highcharts.chart('container', this.options);
    });
  }

  onReset() {
    this.router.navigate(['/departmentList']);
  }

  constructor(
    private departmentService: DepartmentService,
    private router: Router
  ) {}

  public options: any = {
    chart: {
      type: 'column',
    },
    title: {
      text: '<span class="class1">Browser market shares. January, 2018</span>',
    },
    subtitle: {
      text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>',
    },
    accessibility: {
      announceNewData: {
        enabled: true,
      },
    },
    xAxis: {
      type: 'category',
      title: {
        text: 'Department Names',
      },
    },
    yAxis: {
      title: {
        text: 'Rates',
      },
    },
    legend: {
      enabled: false,
    },
    plotOptions: {
      series: {
        pointWidth: 50,
        borderWidth: 0,
        dataLabels: {
          enabled: true,
          format: '{point.y:.1f}%',
        },
      },
    },

    tooltip: {
      headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
      pointFormat:
        '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>',
    },

    series: [
      {
        name: 'Browsers',
        colorByPoint: true,
        data: [],
      },
    ],
    drilldown: {
      series: []
    },
  };
}
