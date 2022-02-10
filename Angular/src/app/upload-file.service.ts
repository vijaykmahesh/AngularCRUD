import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private http: HttpClient) {
  }

  upload(file: File): Observable<any> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    return this.http.post(`${baseUrl}/upload`, formData);
  }

  
  getFiles(id:string): Observable<any> {
    return this.http.get(`${baseUrl}/files/${id}`);
  }
}