import React from 'react';
import {Route,IndexRoute} from 'react-router';
import App from './components/App';
import Greetings from './components/Greetings';
import SignupPage from './components/signup/SignupPage';
import Home from './components/Home';
import electronics from './components/electronics';
import furniture from './components/furniture';
import dress from './components/dress';

export default(
    <Route path="/" component={App}>
    <IndexRoute component={Greetings}/>
 
        <Route path="signup" component={SignupPage}/>
        <Route path="home" component={Home}/>
        <Route path="electronics" component={electronics}/>
        <Route path="furniture" component={furniture}/>
        <Route path="dress" component={dress}/>
    </Route>
)