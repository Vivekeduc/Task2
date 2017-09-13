import{Component} from '@angular/core';
import{Register} from './register';
import{NgForm} from '@angular/forms';
import{Register} from './register';

@Component({
  selector:'my-app',
  templateUrl:'./src/register.html'
})
export class RegisterComponent{
  
  register = new Register('Hary', 'J', 'hary@mail.com',123123);
  
  
}