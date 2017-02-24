var io = require('socket.io').listen(8000);	
		 
var mysql = require('mysql');

var connection1 = mysql.createConnection({
	host : 'localhost' ,
	user : 'root',
	password : 'rellda',
	database : 'Clube'   
});

var connection2 = mysql.createConnection({
	host : 'localhost' ,
	user : 'root',
	password : 'rellda',
	database : 'Clube'   
});


connection1.connect();
connection2.connect();

console.log("Aguardando Conexoes do Cliente");

io.on('connection', function(socket) {
    
	console.log('Um cliente se conectou ao servidor');

	socket.on('message',function(info){
    	
    	console.log("Recebendo pedido de atualizacao: "+info);
    	
        var atualizar = info;
        
        if(atualizar == 2){
        connection2.query('SELECT Nome FROM tblCadastro WHERE Presente = ?', "Sim" , function(err, rows, fields){
			if(err) throw err;
			
			var limite = rows.length;//imagem
			var nomes = [];
			for(var i = 0; i<limite;i++)
				nomes[i] = rows[i].Nome;

			socket.emit('nomes', nomes);
			
       	});	

        atualizar = 0;
        }
    
        if(atualizar == 1){
       			 
		connection1.query('SELECT Temperatura FROM tblDados WHERE id = ?', 1 , function(err, rows, fields){
			if(err) throw err;
			var temperatura = rows[0].Temperatura;//imagem
			console.log("Foi pego a temperatura: "+temperatura); 
			socket.emit('temperatura', temperatura);
       	});

       	connection1.query('SELECT LDR FROM tblDados WHERE id = ?', 1 , function(err, rows, fields){
			if(err) throw err;
			var ldr = rows[0].LDR;//imagem
			console.log("Foi pego a luminosidade: "+ldr); 
			socket.emit('ldr', ldr);
       	});

       	connection1.query('SELECT Umidade FROM tblDados WHERE id = ?', 1 , function(err, rows, fields){
			if(err) throw err;
			var umidade = rows[0].Umidade;//imagem
			console.log("Foi pego a umidade: "+umidade); 
			socket.emit('umidade', umidade);
       	});

       	connection1.query('SELECT Volume FROM tblDados WHERE id = ?', 1 , function(err, rows, fields){
			if(err) throw err;
			var volume = rows[0].Volume;//imagem
			console.log("Foi pego o volume: "+volume);
			socket.emit('volume', volume); 
       	});	

       	atualizar = 0;
       }
	});	  
});