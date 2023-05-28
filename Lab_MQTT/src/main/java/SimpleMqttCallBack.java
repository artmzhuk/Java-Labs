import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class SimpleMqttCallBack implements MqttCallback {

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String message = new String(mqttMessage.getPayload());
        System.out.println("Message received:\t"+ message);
        JSONObject jo = new JSONObject(message);
        System.out.println(jo.opt("age"));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}