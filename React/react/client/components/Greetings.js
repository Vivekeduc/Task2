import React from 'react';
import SigninPage from './signin/SigninPage';



class Greetings extends React.Component{
    render()
    {
        return(
            <div className="container">
            <SigninPage/>
            </div>
        );
    }
}

export default Greetings;