const express = require('express')
const cors = require('cors')
const mysql = require('mysql2')
const app = express();
const port = process.env.PORT;

app.use(cors({origins: '*'}))
app.get('/alumno',(req,res)=>{

    const pool = mysql.createPool({
        host: process.env.DBHOST,
        user: process.env.DBUSER,
        password: process.env.DBPASSWORD,
        database: process.env.DBNAME,
        connectionLimit:10,
    });

    const sql = 'SELECT * FROM persona';
    pool.query(sql,(err,rows,fields)=>{
        if(err){
            res.json(err);
        }else{
            res.json(rows)
        }

    });

});
app.listen(port,()=>{

    console.log("escuychando en el puerto:"+port);
})