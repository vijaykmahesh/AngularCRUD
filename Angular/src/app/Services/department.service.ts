import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8080/Api/services';

@Injectable({
  providedIn: 'root',
})
export class DepartmentService {
  constructor(private http: HttpClient) {}

  createDepartment(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/createDepartment`, data);
  }

  getAllDepartments(): Observable<any> {
    return this.http.get(`${baseUrl}/getAllDepartments`);
  }

  updateDepartment(data: any): Observable<any> {
    return this.http.put(`${baseUrl}/updateDepartment`, data);
  }

  deleteDepartment(departmentId: any): Observable<any> {
    return this.http.delete(
      `${baseUrl}/deleteDepartment?departmentId=` + departmentId
    );
  }

  getDepartmentByDepartmentId(departmentId: any): Observable<any> {
    return this.http.get(
      `${baseUrl}/getDepartmentByDepartmentId?departmentId=` + departmentId
    );
  }
}
