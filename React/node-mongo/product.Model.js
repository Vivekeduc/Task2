var mongoose = require('mongoose'),
schema = mongoose.Schema;
var productSchama =new schema({
  
    product_category:String,
    product_name:String,
    cost:Number,
    quantity:Number,
    imgurl:String,
    brand:String,
    model:String,
    description:String


    
    });
    
module.exports = mongoose.model('productSchama',productSchama);
	
