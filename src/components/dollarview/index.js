import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const DollarView = (props) =>{
    return(
        <View style={style.container}>
            
            <View style={style.containerTop}>

            <Text style={{fontSize: 20}}> 1 Dolar Americano:</Text>

            </View>
            
            <Text style={style.dollarText}>R$ {props.dollarPrice}</Text>

        </View>
    );
}

const style = StyleSheet.create({
    container:{
        backgroundColor: '#009933',
        alignItems: 'center',
        paddingBottom: 10,
        borderRadius: 5,
        
    },
    containerTop:{
        backgroundColor: '#00cc44',
        paddingHorizontal: 60,
        borderTopLeftRadius: 5,
        borderTopRightRadius: 5
    },

    dollarText:{
        fontSize: 70,
    },
});

export default DollarView;