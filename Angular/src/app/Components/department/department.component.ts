import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Department } from 'src/app/Models/Department.model';
import { DepartmentService } from 'src/app/Services/department.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import Swal from 'sweetalert2';
import { UploadFileService } from 'src/app/upload-file.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css'],
})
export class DepartmentComponent implements OnInit {
  displayedColumns: string[] = [
    'departmentName',
    'employeeName',
    'dateOfJoining',
    'uploadImage',
    'Actions',
  ];
  selectedFiles: FileList;
  dataSource = new MatTableDataSource<Department[]>();
  currentFile: File;
  progress = 0;
  message = '';
  fileInfos: Observable<any>;
  profileImg: any;
  base64Data: any;
  retrieveResonse: any;
  departmentId: any;
  imageName: any;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @Input() isSpinnerShown: boolean;
  constructor(
    private departmentService: DepartmentService,
    private toastr: ToastrService,
    private router: Router,
    private uploadFileService: UploadFileService
  ) {}

  ngOnInit(): void {
    this.getAllDepartments();
  }

  selectFile(event, departmentId) {
    this.selectedFiles = event.target.files;
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.uploadFileService.upload(this.currentFile, departmentId).subscribe(
      (response) => {
        this.profileImg = response.url;
        this.departmentId = departmentId;
      },
      (err) => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      }
    );

    this.selectedFiles = undefined;
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

  getAllDepartments() {
    this.departmentService.getAllDepartments().subscribe((response) => {
      this.dataSource.data = response;
    });
  }

  fetchDepartmentById(departmentId: any) {
    this.router.navigate(['/edit-Department', departmentId]);
  }

  deleteDepartmentById(departmentId: any) {
    Swal.fire({
      title: 'Are you sure want to Delete?',
      text: 'You will not be able to recover this file!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it',
    }).then((result) => {
      if (result.value) {
        this.departmentService
          .deleteDepartment(departmentId)
          .subscribe((response) => {
            this.toastr.success('Department Deleted Successfully');
            this.getAllDepartments();
          });
      } else {
        this.router.navigate(['/departmentList']);
      }
    });
  }
}
