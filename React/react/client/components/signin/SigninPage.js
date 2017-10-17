import React from 'react';
import {connect} from 'react-redux';
import SigninForm from './SigninForm';

import {userSignin} from '../../actions/signinAction';

class SigninPage extends React.Component{
    render()
    {
        const {userSignin}=this.props;
        return(
         <div className="container">
              <SigninForm  userSignin={userSignin}/>
         </div>
        );
    }
}
SigninPage.propTypes={
    userSignin: React.PropTypes.func.isRequired
}

export default connect(null,{userSignin}) (SigninPage);