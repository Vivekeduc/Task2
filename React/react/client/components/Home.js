import React from 'react';


class Home extends React.Component{
constructor(props,context){
    super(props,context);
    this.handleClick = this.handleClick.bind(this);
}

    handleClick(value) {
     //  event.preventDefault();
       console.log(value);
        let url = "/"+value;
        this.context.router.push(url);
        
      } 
    render()
    {
        return(
         <div className="container">
               <div 
               onClick={this.handleClick.bind(event, 'electronics')}>
                    <button type="button" className="btn btn-primary">Electronics</button></div>
        <br />
        <div  onClick={this.handleClick.bind(event, 'furniture')}>    <button type="button" className="btn btn-success">furniture</button></div>
        <br />
        <div  onClick={this.handleClick.bind(event, 'dress')}> <button type="button" className="btn btn-danger">dress</button></div>

         </div>
       
        );
    }
}

Home.contextTypes={
    router: React.PropTypes.object.isRequired
}

export default Home;