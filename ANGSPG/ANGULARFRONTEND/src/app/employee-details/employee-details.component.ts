import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  standalone: false,
  
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css'
})
export class EmployeeDetailsComponent {
  id:number=0;
  employee:Employee=new Employee();
  constructor(private route:ActivatedRoute,
    private employeeService:EmployeeService
  ){
  }
  ngOnInit():void{
    this.id=this.route.snapshot.params['id'];
    this.employee=new Employee;
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee=data;
    })
  }

}
