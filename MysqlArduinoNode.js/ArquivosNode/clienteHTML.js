function clubeEsperto(){

                        var socket = io.connect('http://localhost:8000');

                        socket.emit('message', 1);
                        
                        
                        socket.on('temperatura', function(temperatura){
                            
                            var temp = document.getElementById("temperatura");
             
                            temp.innerText = "Temperatura: "+temperatura+"C";

                        });

                        
                        socket.on('ldr', function(ldr){

                            var lux = document.getElementById("ldr");
             
                            lux.innerText = "Luminosidade: "+ldr+" u.ldr";

                        });


                        socket.on('umidade', function(umidade){

                            var umid = document.getElementById("umidade");
             
                            umid.innerText = "Umidade Relativa do ar: "+umidade+"%";

                        });


                        socket.on('volume', function(volume){

                            var vol = document.getElementById("volume");
                 
                            vol.innerText = "Volume: "+volume+"u.v";
                            
                        });
}

function clubeEsperto2(){

                        var socket = io.connect('http://localhost:8000');

                        socket.emit('message', 2);   


                        socket.on('nomes', function(nomes){

                            var n = document.getElementById("presentes");
                 
                            n.innerText = nomes;
                            
                        }); 







}
                  
        