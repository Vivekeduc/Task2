const React= require ('react');
const ReactDOM= require('react-dom');

import {browserHistory} from 'react-router';
import axios from 'axios';
class electronics extends React.Component{
    constructor(props) {
        super(props);
        
        this.state = {
items:[],
quantity:Number,
entred_updated_quantity:Number,
selectedIndex:Number,
selsctedDisc:[]
       
        }
        this.handleClickbuy = this.handleClickbuy.bind(this);
        this.handleClickPlaceOrder=this.handleClickPlaceOrder.bind(this);
    }
componentDidMount(){
    console.log("inside compdidmount");
    this.productList();
}
    productList(){
        console.log("inside productList");
        axios.get(`http://localhost:7337/findbycategory/electronics`).then((data)=>{
            console.log("data came"+data);
   
        console.log(data["data"]);
        this.setState({items :  data["data"]});
    
    });
    }
    handleClickPlaceOrder(event) {
     // this.state.selsctedDisc.q = this.state.selsctedDisc.q-select quantity;
     event.preventDefault();
    let q= this.state.selsctedDisc.quantity - +(this.state.entred_updated_quantity);
     let x ={
       id:this.state.selsctedDisc._id,
       quantity:q
     };
      
    axios.post(`http://localhost:7337/test`,x).then(()=>{
      console.log("updated product ");
      this.context.router.push('/home');
    });
      //this.state.selsctedDisc;
        }
            handleClickbuy(index) {

              
              this.setState({selsctedDisc:this.state.items[index]});
             this.setState({ quantity:this.state.items[index].quantity});
             
        $("#myModalsignin").modal("show");
      }

    handleClick(i,event) { 
       

              
               
    }//********************************************************************************************* */
  //   handleQuantityChange(e) {
  //     console.log("entered value="+e.target.value);
 
  //  console.log("max value is"+e.target.max);
  //  let updatedValue = e.target.max -e.target.value;
  //  console.log("updated value: "+updatedValue);
  //  this.setState({updated_quantity:updatedValue},()=>{console.log("updated value added to state")});
  //  }
    render() {

        const css={
           height:'170px',
           width:'170px'

        }
        const css2={
          height:'100px',
          width:'100px'

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
                    <div>
                        <div className="col col-md-3" style={m} onClick={this.handleClick.bind(this,index)} key={index}>
                                <img src={obj.imgurl} style={css} />
                                <div onClick={this.handleClickbuy.bind(this,index)}> <button type="button" className="btn btn-info"> buy </button></div>
                                <h4><b>{obj.cost}</b></h4>  
                                
                                            
                        </div>
                        <div id="myModalsignin" className="modal fade" role="dialog" aria-hidden="true">
                        <div className="modal-dialog">
                          <div className="modal-content">
                            <div className="modal-header">
              
                              <button type="button" className="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h1 className="text-center">Buy this Product</h1>
                            </div>
                            <div className="modal-body">
                              
                              <form className="form col-md-12 center-block">
                                <div className="form-group">
                                <img src={this.state.selsctedDisc.imgurl} style={css2}/>
                                </div>
                                <div className="form-group">
                                
                                <p>disc:{this.state.selsctedDisc.description}</p>
                                <p>price:{this.state.selsctedDisc.cost}</p>
                                Quantity :
                                <input type="number" name="quantity" min="1" max={this.state.quantity}  onChange={(e)=>{this.setState({entred_updated_quantity:+e.target.value},()=>{console.log("value updated"+this.state.entred_updated_quantity)})}}/>
                                </div>
                                <div className="form-group">
                                  <button onClick={this.handleClickPlaceOrder.bind(this)} className="btn btn-primary btn-lg btn-block">Place Order</button>
                                  
                                </div>
                              </form>
                            </div>
                            <div className="modal-footer">
              
                              <div className="col-md-12">
                                <button className="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
              
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>




                        
                    </div>
                    )
                });
            
        return (
            <div>
                {listItems}
            </div>
         );
    }
}

electronics.contextTypes={
  router: React.PropTypes.object.isRequired
}

export default electronics;