import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Alert, StatusBar } from 'react-native';
import axios from 'axios';
import DollarView from '../../components/dollarview';
import Textinput from '../../components/textInput';
import Mybutton from '../../components/button';

const HomeScreen = () =>{
    
let [dollarData, setDollarData] = useState(); //variavel, função
let [valueInput, setValueInput] = useState();
let [convertedPrice = 0.00, setConvertedPrice] = useState();

    useEffect(() =>{
        
        const interval = setInterval(() => { // Pega os dados a cada 30 segundos

            axios.get('https://economia.awesomeapi.com.br/all/USD-BRL')
            .then(({data}) =>{
                setDollarData(data.USD.high);
            }, [])
            .catch(() =>{
                Alert.alert(
                    'Erro!',
                    'Servidor Não Contactado!',
                    [{ text: 'OK' }],
                    { cancelable: false }
                );
            });
            
        }, 1000);
        return () => clearInterval(interval); //Para atualizar a cada segundo
        
    }, []); /* [] Para não ficar repetindo */
    

    function convertValues(){
        valueInput === undefined || NaN ? valueInput = 0.00 :
        setConvertedPrice(valueInput * dollarData);
        console.log(convertedPrice);
        return convertedPrice
    }


    return(
        <View style={styles.container}>

            <StatusBar
            backgroundColor="green"
            barStyle='light-content'
            />

            <DollarView dollarPrice ={Number(dollarData).toFixed(2).replace('.',',')}/>
            
            <Text style={styles.textDivisor}>Converter de Dolar para Real:</Text>
            
            <Textinput 
            placeholder = "Valor em Dolar"
            style ={{fontSize: 20, textAlign: 'center'}}
            textedit = "true"
            onChangeText ={(value) => setValueInput(value.replace(',','.'))}/>
            
            <Text style={styles.convertedValue}>R$ {Number(convertedPrice).toFixed(2).replace('.',',')}</Text>

            <Mybutton
            title="Converter"
            customClick={() => {convertValues()}} />

        </View>
    );
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: -240,
    },
    textDivisor:{
        marginTop: 5,
        fontSize: 20
    },
    convertedValue:{
        fontSize: 30,
    },
});

export default HomeScreen;
