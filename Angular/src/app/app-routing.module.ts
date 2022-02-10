import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEditDepartmentComponent } from './Components/add-edit-department/add-edit-department.component';
import { DepartmentComponent } from './Components/department/department.component';
import { FusionChartsComponent } from './fusion-charts/fusion-charts.component';
import { HighChartsComponent } from './high-charts/high-charts.component';

const routes: Routes = [
  { path: 'add-Department', component: AddEditDepartmentComponent },
  {
    path: 'edit-Department/:departmentId',
    component: AddEditDepartmentComponent,
  },
  { path: 'departmentList', component: DepartmentComponent },
  { path: 'high-charts', component: HighChartsComponent },
  { path: 'fusion-charts', component: FusionChartsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
