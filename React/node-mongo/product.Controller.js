var mongoose = require('mongoose');

var product = require('./product.Model');
var bodyParser = require('body-parser')
express = require('express');



app=express();


var http =require('http').Server(app);

mongoose.connect('mongodb://localhost/mydbs');

app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());



app.get('/findbycategory/:category', function (req, res, next) {

    var category = req.params.category;
   
    product.find({"product_category":category},function (err, products) {
        if(err) { res.status(404).send("error"+err); }
        else{
                if(products)
                
                res.json(products);
            
            }

    });
 
});

app.post('/updateProduct',function(req,res){

var id = req.body.id;
console.log("product id :"+id);
product.findById(id,(err,product)=>{
    console.log("old prod quantity:"+product.quantity);
    console.log("user entred quantity:"+req.body.quantity);
    product.quantity =    product.quantity -   +(req.body.quantity);
    console.log("updted quantity is:"+product.quantity);
   

});



res.json({});
});

app.post('/test',function(req,res){
    
    var id = req.body.id;
    var updated_quantity =req.body.quantity;
console.log("req came "+id);
console.log("quantity : "+req.body.quantity);
 product.findByIdAndUpdate(id, {
    $set: {
        quantity:updated_quantity
    }
}, (result)=>{console.log("product updated"+result)});



res.json({});

});






app.route('/').get((req,res)=>{

    product.find({},function (err, products) {
        if(err) { res.status(404).send("error"+err); }
        else{if(products)
            
            res.json(products);
            
            }
    });
});

app.route('/add').post((req,res)=>{

    console.log("inside post "+req.body);
product.create(req.body,(err,feedback)=>{
if(err){res.status(404).send(err);}
else{
    console.log(feedback);
    res.send(feedback);

}

 });

// req.on('data',(d)=>{
//     console.log("post data is:"+ d);
//      product.create( d.json,(err,feedback)=>{

//     //     console.log(feedback);

// });

// })

});

http.listen(7337,()=>{
    console.log("port started on 7337")
});