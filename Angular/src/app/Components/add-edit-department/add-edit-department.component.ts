import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Department } from 'src/app/Models/Department.model';
import { DepartmentService } from 'src/app/Services/department.service';

export const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'DD/MM/YYYY',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY'
  },
};

@Component({
  selector: 'app-add-edit-department',
  templateUrl: './add-edit-department.component.html',
  styleUrls: ['./add-edit-department.component.css'],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ]
})
export class AddEditDepartmentComponent implements OnInit {
  selectedFiles?: FileList;
  currentFile?: File;
  message = '';
  errorMsg = '';
  isSpinnerShown = false;
  departmentForm: FormGroup;
  submitted = false;
  department: Department = {
    departmentId: 0,
    departmentName: '',
    employeeName:'',
    dateOfJoining:''
  };
  departmentId: any;
  constructor(
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private departmentService: DepartmentService,
    private router: Router,
  ) {}

  ngOnInit() {
    this.department.departmentId = this.route.snapshot.params['departmentId'];
    this.departmentForm = this.formBuilder.group({
      departmentId:'',
      departmentName: ['', Validators.required],
      employeeName: ['', Validators.required],
      dateOfJoining:['', Validators.required],
    });
    this.departmentService
      .getDepartmentByDepartmentId(this.department.departmentId)
      .subscribe((response) => {
        console.log(response.dateOfJoining);
        this.department = response;
      });
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.departmentForm.controls;
  }

  async onSubmit() {
    this.submitted = true; 

    // stop here if form is invalid
    if (this.departmentForm.invalid) {
      return;
    }
    if (
      this.department.departmentId == undefined ||
      this.department.departmentId == null
    ) {
      await this.departmentService
        .createDepartment(this.departmentForm.value)
        .toPromise();
      
      this.toastr.success('Department created Successfully');
      this.isSpinnerShown = true;
      setTimeout(() => {
        this.isSpinnerShown = false;
        this.onReset();
      }, 500);
    } else {
      this.updateDepartment(this.department.departmentId);
    }
  }

  onReset() {
    this.router.navigate(['/departmentList']);
  }

  async updateDepartment(departmentId: any) {
    this.departmentForm.value.departmentId = departmentId;
    await this.departmentService.updateDepartment(this.departmentForm.value).toPromise();
    this.toastr.success('Department Updated Successfully');
    this.isSpinnerShown = true;
    setTimeout(() => {
      this.isSpinnerShown = false;
      this.fetchAllDepartments();
    }, 500);
  }

  fetchAllDepartments() {
    this.router.navigate(['/departmentList']);
  }
}
