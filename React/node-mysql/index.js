var mysql = require('mysql');
var express= require('express');
var bodyParser=require('body-parser');
app = express();

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "password",
  database: "customer_db"
});

var http=require('http').Server(app);
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

app.route('/allusers').get( function(req,res){
  con.query("select * from customers", function (err, result, fields) {
    if (err) throw err;
    res.json(result);
  });


}    );


app.route('/getuserbyusername').get((req,res)=>{
  var username = req.query.username;
  var password=req.query.password;
 
  con.query("select * from customers where username="+"'"+username+"'"+" and password="+"'"+password+"'", function (err, result, fields) {
    console.log(username);
    if (err) throw err;
   console.log(result[0]);
  if(result[0]!=null){
    console.log("200");
    res.status(200);
    res.send("true");
  }else{
    console.log("400");
  res.status(404);
  res.send("false");
  }
//     if(result[0].password===password)
// {
//     res.send("true");
//     res.status(200);
// }
//     else{
//       res.send("false");
//       res.status(400);
//     }

});
//con.end();
});




app.route('/adduser').post((req,res)=>{

  var input = JSON.parse(JSON.stringify(req.body));
  
var data = {
  username:input.username,
  email  : input.email,
  password : input.password
 


};
  con.query("INSERT INTO customers set ? ",data, function (err, result, fields) {
    if (err) throw err;
    console.log(result);
  });


});


//----------------insert a user-----------------//

 http.listen(6336,function(){
     console.log("server running on 6336");
 });

