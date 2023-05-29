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
        int a = Integer.parseInt(jo.opt("a").toString());
        int b = Integer.parseInt(jo.opt("b").toString());
        int c = Integer.parseInt(jo.opt("c").toString());
        if ((b*b - 4*a*c) < 0){
            System.out.println("No solutions for: "+ a +" "+" "+c);
        } else if ((b*b - 4*a*c) == 0){
            double sol1 = ((b)/(2*a));
            System.out.println("Solution is: " + sol1);
        } else {
            double sol1 = ((b+ Math.sqrt((double) b*b - 4*a*c))/(2*a));
            double sol2 = ((b- Math.sqrt((double) b*b - 4*a*c))/(2*a));
        }

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}