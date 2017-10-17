
import React from 'react';


import {browserHistory} from 'react-router';


class SigninForm extends React.Component{

    constructor(props)
    {
        super(props);
        this.state={
            username:'',
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
        // console.log(this.state);
        // this.context.router.push('/home');
       this.props.userSignin(this.state.username,this.state.password)
    //    .then(
    //        ()=>{
    //            console.log("user auth");
    //            this.context.router.push('/home');
    //        }
    //    );
    .then((result) => {
    
            if (result.status === 200) {
                console.log("user auth");
                this.context.router.push('/home');
            }else{
                this.context.router.push('/');
            }
         
           })


    }
    render()
    {
       
        return(

            <div className="row">
                <div className="col-md-4 col-md-offset-4">
                <form onSubmit={this.onSubmit}>    
                     <h1>User Login Form</h1>
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
                         <button className="btn btn-primary btn-lg">
                                 Sign In
                          </button>
                    </div>
                </form>
                </div>
            </div>
        
        );
    }
}

SigninForm.propTypes={
    userSignin: React.PropTypes.func.isRequired
}

SigninForm.contextTypes={
    router: React.PropTypes.object.isRequired
}

export default SigninForm;