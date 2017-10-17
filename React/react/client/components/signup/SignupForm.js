
import React from 'react';


import {browserHistory} from 'react-router';

class SignupForm extends React.Component{

    constructor(props)
    {
        super(props);
        this.state={
            username:'',
            email:'',
            password:''
           
        }

        this.onChange=this.onChange.bind(this);
        this.onSubmit=this.onSubmit.bind(this);
        }
      
    onChange(e)
    {
        this.setState({[e.target.name]: e.target.value});
    }
    onSubmit(e)
    {
        e.preventDefault();
        console.log(this.state);
        this.props.userSignup(this.state).then((result)=>{console.log("person added"+result)});
    }
    render()
    {
        
        return(

            <div className="row">
                <div className="col-md-4 col-md-offset-4">
                <form onSubmit={this.onSubmit}>    
                     <h1>Create Account Form</h1>
                     <div className="form-group">
                         <label>User Name</label>
                         <input  
                            value={this.state.username}
                            onChange={this.onChange}
                             type="text" 
                             name="username" 
                             className="form-control"/>

                     </div>
                     <div className="form-group">
                         <label>Password</label>
                         <input  
                            value={this.state.password}
                            onChange={this.onChange}
                             type="password" 
                             name="password" 
                             className="form-control"/>

                     </div>
                            
                     <div className="form-group">
                         <label>Email</label>
                         <input  
                            value={this.state.email}
                            onChange={this.onChange}
                             type="text" 
                             name="email" 
                             className="form-control"/>

                     </div>
                    
                    
                     <div className="form-group">
                         <button className="btn btn-primary btn-lg">
                             Signup
                          </button>
                    </div>
                </form>
                </div>
            </div>
        
        );
    }
}

SignupForm.propTypes={
    userSignup: React.PropTypes.func.isRequired
}

export default SignupForm;