#include "DHT.h"
#include <Adafruit_Sensor.h>

DHT dht(13, DHT11);
int temperatura = 0;
int umidade = 0;
String separarGrandezas = ";"; 
int luminosidade = 0;
int potenciometro = 0;
const int ABRE = 1;
const int FECHA = 0;
const int BUZZER = 2;
int inByte;


void setup(){
pinMode(12, OUTPUT);
pinMode(11, OUTPUT);
pinMode(10, OUTPUT);
pinMode(9, OUTPUT);
pinMode(ABRE, OUTPUT);
pinMode(FECHA, OUTPUT);
pinMode(BUZZER, OUTPUT);
Serial.begin(9600);
dht.begin();

}

void loop(){

  delay(1000);
  temperatura = dht.readTemperature();
  umidade = dht.readHumidity();
  luminosidade = analogRead(A0);
  potenciometro = analogRead(A1);
   
 
  recebeDados();
  enviaDados();
  controleVolume(potenciometro);
  
}

void enviaDados(){

  delay(1000);
  Serial.print(temperatura);
  Serial.print(separarGrandezas);
  Serial.print(umidade);
  Serial.print(separarGrandezas);
  Serial.print(luminosidade);
  Serial.print(separarGrandezas);
  Serial.print(potenciometro/10);
  Serial.print(separarGrandezas);
  Serial.print("0");
  Serial.print(separarGrandezas);
  Serial.print("0");
  Serial.print(separarGrandezas);
  Serial.print("0");
  Serial.print(separarGrandezas);
  Serial.print("0");
  Serial.println();
  
}

void controleVolume(int p){ 
  if(p<250){
  digitalWrite(12, LOW);
  digitalWrite(11, LOW);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
  }
  else if(p>=250 & p<500){
  digitalWrite(12, HIGH);
  digitalWrite(11, LOW);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
  }
  else if(p>499 & p<750){
  digitalWrite(12, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
  }
  else if(p>=750 & p<1000){ 
  digitalWrite(12, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(9, LOW);
  }
  else{
  digitalWrite(12, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(9, HIGH);
  }
}

void recebeDados(){
  digitalWrite(ABRE, LOW);
  digitalWrite(FECHA, LOW);
  
  if(Serial.available()>0){
    
    inByte = Serial.read();
    
    if(inByte == '1'){
      digitalWrite(ABRE, HIGH);
      digitalWrite(FECHA, LOW);
      delay(2000);
      inByte = 2;
    }
    else if(inByte == '0'){
      digitalWrite(ABRE, LOW);
      digitalWrite(FECHA, HIGH);
      delay(2000);
      inByte = 2;
    }
    
  }
  if(FECHA == HIGH){
    tone(BUZZER, 1500);
  } 
  else
    noTone(BUZZER);


}
