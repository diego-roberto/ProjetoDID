package main;

import entity.Cabo;

//Autor: Diego Roberto

public class Calculo {
    
   public Integer calculoValor(Cabo objCabo) {      
   
         
   String vOri = objCabo.getOrigem();
   String vDes = objCabo.getDestino();
   String vReO = objCabo.getReguaOrigem();
   String vReD = objCabo.getReguaDestino();
   Integer vTO = Integer.parseInt(objCabo.getTribOrigem());
   Integer vTD = Integer.parseInt(objCabo.getTribDestino());
   Integer vRaO = Integer.parseInt(objCabo.getRackOrigem());
   Integer vRaD = Integer.parseInt(objCabo.getRackDestino());
    
   Integer valor = 0;
   
    //constantes    
   Integer sentidoFila = 3; // Sentido da Fila
   Integer espHorizontal  = 5; //Espaçamento Horizontal
   Integer espVertical = 9; // Espaçamento Vertical
   Integer espRegua = 17; // Espaço vertical de uma régua inteira
   
    /*
    Cálculo do cabo:
    pontoComumOrigem + espHoriz + espVert + sentidoFila + pontoComumDestino
    */
        
        //verifica sentido da fila e adiciona valor caso sejam opostas
        if ("l".equals(vOri) && "m".equals(vDes)) {   
            valor += sentidoFila;
        }else if ("m".equals(vOri) && "l".equals(vDes)) {
            valor += sentidoFila;
        }
                
        //adiciona valor de saída (ORIGEM) até o ponto comum
        if ("D".equals(vReO)) { //sai apenas para baixo
            if (vTO <= 4) {
                valor += 19;
            }else if (vTO <= 8) {
                valor += 15;
            }else if (vTO <= 12) {
                valor += 10;
            }else if (vTO <= 16) {
                valor += 7;
            }
            
        }else if ("C".equals(vReO)) { //sai para cima e para baixo
            if (vTO <= 4) {
                valor += 7;
            }else if (vTO <= 8) {
                valor += 15;
            }else if (vTO <= 12) {
                valor += 15;
            }else if (vTO <= 16) {
                valor += 7;           
            }
            
        }else if ("B".equals(vReO)) { //sai para cima e para baixo
            if (vTO <= 4) {
                valor += 7;
            }else if (vTO <= 8) {
                valor += 15;
            }else if (vTO <= 12) {
                valor += 15;
            }else if (vTO <= 16) {
                valor += 7;
            }
        }else if ("A".equals(vReO)) { //sai apenas para cima
            if (vTO <= 16) {
                valor += 19;
            }else if (vTO <= 12) {
                valor += 15;
            }else if (vTO <= 8) {
                valor += 10;
            }else if (vTO <= 4) {
                valor += 7;
            }
        }
        
        //adiciona valor de espaçamento horizontal
        if (vRaO < vRaD) {
            for (int i = vRaO; i < vRaD; i++) {
                valor += espHorizontal;
            }
        }else if (vRaO > vRaD) {
            for (int i = vRaD; i < vRaO; i--) {
                valor += espHorizontal;
            }
        }
        
        //adiciona valor vertical
        switch (vReO) {
            case "D":   //se Regua de ORIGEM é D
                switch (vReD){
		case "D": break;		
		case "C":	//se Regua de DESTINO é C
		if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
		case "B": 	//se Regua de DESTINO é B
		valor += espRegua; //recebe espaço da Regua C inteira
		if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
		case "A":	//se Regua de DESTINO é A
                valor += espRegua *2; //recebe espaço da Regua B e C inteira
		if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else if (vTD >=8 && vTD >= 5){
			valor += 15;
		}else{
			valor += 19;
		}
		break;
            }
            case "C":   //se Regua de ORIGEM é C
                switch (vReD){
		case "D": 			
		if	(vTD >= 13){
			valor += 19;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 15;
		}else if (vTD >=8 && vTD >= 5){
			valor += 10;
		}else{
			valor += 7;
		}
		break;		
		case "C": break;
		case "B": 			
		if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
		case "A":	
		valor += espRegua; //recebe espaço da Regua B inteira
		if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else if (vTD >=8 && vTD >= 5){
			valor += 15;
		}else{
			valor += 19;
		}
		break;
            }
            case "B":
                switch (vReD){
                case "D":
		valor += espRegua;
		if	(vTD >= 13){
			valor += 19;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 15;
		}else if (vTD >=8 && vTD >= 5){
			valor += 10;
		}else{
			valor += 7;
		}
		break;
                case "C":
                if (vTD >= 4){
			valor += 7;
		}else if (vTD >= 5 && vTD <=8 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
                case "B": break;
                case "A":
                if	(vTD >= 13){
			valor += 7;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 10;
		}else if (vTD >=8 && vTD >= 5){
			valor += 15;
		}else{
			valor += 19;
		}
		break;
            }
            case "A":
                switch (vReD){
                case "D":
		valor += espRegua *2; //recebe espaço da Regua B e C inteira
		if	(vTD >= 13){
			valor += 19;
		}else if (vTD >= 12 && vTD <=9 ){
			valor += 15;
		}else if (vTD >=8 && vTD >= 5){
			valor += 10;
		}else{
			valor += 7;
		}
		break;		
		case "C":
		valor += espRegua; //recebe espaço da Regua B inteira
		if (vTD >= 4){
			valor += 7;
		}else if (vTD >= 5 && vTD <=8 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
		case "B": 			
		if (vTD >= 4){
			valor += 7;
		}else if (vTD >= 5 && vTD <=8 ){
			valor += 10;
		}else{
			valor += espRegua + espVertical;
		}
		break;
		case "A": break; 
                }               
        }
        
        
        //adiciona valor de saída (DESTINO) até o ponto comum         
        if ("D".equals(vReD)) { //sai apenas para baixo
            if (vTD <= 4) {
                valor += 19;
            }else if (vTD <= 8) {
                valor += 15;
            }else if (vTD <= 12) {
                valor += 10;
            }else if (vTD <= 16) {
                valor += 7;
            }
            
        }else if ("C".equals(vReD)) { //sai para cima e para baixo
            if (vTD <= 4) {
                valor += 7;
            }else if (vTD <= 8) {
                valor += 15;
            }else if (vTD <= 12) {
                valor += 15;
            }else if (vTD <= 16) {
                valor += 7;           
            }
            
        }else if ("B".equals(vReD)) { //sai para cima e para baixo
            if (vTD <= 4) {
                valor += 7;
            }else if (vTD <= 8) {
                valor += 15;
            }else if (vTD <= 12) {
                valor += 15;
            }else if (vTD <= 16) {
                valor += 7;
            }
        }else if ("A".equals(vReD)) { //sai apenas para cima
            if (vTD <= 16) {
                valor += 19;
            }else if (vTD <= 12) {
                valor += 15;
            }else if (vTD <= 8) {
                valor += 10;
            }else if (vTD <= 4) {
                valor += 7;
            }
        }               
        
    return valor;
    
    }
}