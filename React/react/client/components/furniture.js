const React= require ('react');
const ReactDOM= require('react-dom');
import axios from 'axios';
class furniture extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
items:[]

       
        }
    }
componentDidMount(){
    console.log("inside compdidmount");
    this.productList();
}
    productList(){
        console.log("inside productList");
        axios.get(`http://localhost:7337/findbycategory/furniture`).then((data)=>{
            console.log("data came"+data);
   
        console.log(data["data"]);
        this.setState({items :  data["data"]});
    console.log("items"+this.s)
    })
    }

    handleClick(i,event) { 
       
     this.props.history.push({
                    pathname: '/aboutelectronics',
                    state: { details: this.state.items[i].brand,sourceUrl: this.state.items[i].imgurl,description: this.state.items[i].description,price: this.state.items[i].cost}
                    
                });
              
               
    }
    render() {

        const css={
           height:'170px',
           width:'170px'

        }
        const m={
            width:'270px',
            height: '290px',
            border:'1px solid',
            margin:'15px',
            padding:'20px',
            
            overflow: 'hidden'
        }
        const imageDetails = this.state.items; 

        const listItems = imageDetails.map((obj,index) => {
                   return (
                   
                    <div className="col col-md-3" style={m} onClick={this.handleClick.bind(this,index)} key={index}>
                            <img src={obj.imgurl} style={css} />
                           
                            <h4><b>{obj.cost}</b></h4>  
                            
                                        
                    </div>)
                });
            
        return (
            <div>
                {listItems}
            </div>
         );
    }
}

export default furniture;