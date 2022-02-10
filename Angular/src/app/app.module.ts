import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddEditDepartmentComponent } from './Components/add-edit-department/add-edit-department.component';
import { HttpClientModule } from '@angular/common/http';
import { DepartmentComponent } from './Components/department/department.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { SpeinnerComponent } from './Components/speinner/spinner.component';
import { DatePipe } from '@angular/common';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MomentDateModule } from '@angular/material-moment-adapter';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { MatTableModule } from '@angular/material/table'
import {MatPaginatorModule} from '@angular/material/paginator';
import {  MatSortModule} from '@angular/material/sort';
import { HighchartsChartModule } from 'highcharts-angular';
import { HighChartsComponent } from './high-charts/high-charts.component';
import { FusionChartsComponent } from './fusion-charts/fusion-charts.component';
import { FusionChartsModule } from 'angular-fusioncharts';

// Import FusionCharts library and chart modules
import * as FusionCharts from 'fusioncharts';
import * as Charts from 'fusioncharts/fusioncharts.charts';
// Load FusionCharts
import * as FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion'
FusionChartsModule.fcRoot(FusionCharts, Charts, FusionTheme);
@NgModule({
  declarations: [
    AppComponent,
    AddEditDepartmentComponent,
    DepartmentComponent,
    SpeinnerComponent,
    HighChartsComponent,
    FusionChartsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FusionChartsModule,
    MatIconModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    MomentDateModule,
    MatPaginatorModule,
    HighchartsChartModule,
    MatIconModule,
    MatTableModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatDatepickerModule,
    TooltipModule.forRoot(),
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
