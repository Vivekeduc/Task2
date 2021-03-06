import React from 'react';
import {connect} from 'react-redux';
import SignupForm from './SignupForm';

import {userSignup} from '../../actions/signupAction';

class SignupPage extends React.Component{
    render()
    {
        const {userSignup}=this.props;
        return(
         <div className="container">
              <SignupForm  userSignup={userSignup}/>
         </div>
        );
    }
}
SignupPage.propTypes={
    userSignup: React.PropTypes.func.isRequired
}

export default connect(null,{userSignup}) (SignupPage);