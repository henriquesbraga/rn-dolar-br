import React from 'react';
import { View, TextInput} from 'react-native';

const Textinput = (props) =>{

    const status = props.textedit === 'true' ? true : false 

    return (
        
        <View
          style={{
            marginLeft: 35,
            marginRight: 35,
            paddingHorizontal: 10,
            marginTop: 10,
            borderColor: '#2D2E32',
            borderWidth: 1,
            borderRadius: 5,
            
          }}>

          <TextInput
            underlineColorAndroid="transparent"
            placeholder={props.placeholder}
            placeholderTextColor="#00802b"
            keyboardType={"numeric"}
            onChangeText={props.onChangeText}
            returnKeyType={props.returnKeyType}
            numberOfLines={props.numberOfLines}
            multiline={props.multiline}
            onSubmitEditing={props.onSubmitEditing}
            style={props.style}
            blurOnSubmit={false}
            value={props.value}
            editable={status}
          />


        </View>

      );
}

export default Textinput;