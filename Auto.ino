// Pines de conexión
const int bluePin    = 3;
const int greenPin   = 5;
const int redPin     = 6;
const int rightWheel = 7;
const int leftWheel  = 8;
const int trigPin    = 11;
const int echoPin    = 12;

// Otras Constantes
const int tamArreglo = 20;

// Variables
int  pingTravelTime[tamArreglo];
char input;

// Structs
struct RGB {
  double red;
  double green;
  double blue;
};

// Método avanzar el auto
void go() {
  digitalWrite(rightWheel, HIGH);
  digitalWrite(leftWheel, HIGH);
}

// Método para parar el auto
void stop() {
  digitalWrite(rightWheel, LOW);
  digitalWrite(leftWheel, LOW);
}

// Método para doblar a la derecha el auto
void turnRight() {
  digitalWrite(rightWheel, LOW);
  digitalWrite(leftWheel, HIGH);
}

// Método para doblar a la izquierda el auto
void turnLeft() {
  digitalWrite(leftWheel, LOW);
  digitalWrite(rightWheel, HIGH);
}

// Método para calcular la distancia atraves del sensor ultrasonido
void revisarDistancia() {
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  pingTravelTime[0] = pulseIn(echoPin, HIGH);
  delay(25);
  digitalWrite(trigPin, LOW);
}

// Método para calcular el promedio de las ultimas distancias obtenidas
int pingTravelTimeX() {
  long suma = 0;
  for(int i = 0; i < tamArreglo; i++) {
    suma += pingTravelTime[i];
  }
  return int(suma/40);
}

// Método para determinar el color que tendra el led dependiendo la distancia
struct RGB ledColor(int time) {
  RGB color;
  if(time <= 1000) {
    color.red = 255;
    color.green = 0;
    color.blue = 0;
  } else if(1000 < time && time <= 3000) {
    color.red   = -0.1275*time + 382.5;
    color.green = 0.1275*time - 127.5;
    color.blue  = 0;
  } else if(3000 < time && time <= 5000) {
    color.red   = 0;
    color.green = -0.1275*time + 382.5;
    color.blue  = 0.1275*time - 127.5;
  } else if(5000 < time && time <= 7000) {
    color.red   = 0.1275*time - 127.5;
    color.green = 0;
    color.blue  = 255;
  } else {
    color.red   = 255;
    color.green = 0;
    color.blue  = 255;
  }
  return color;
}

// Método para encender el led RGB
void colorearLed() {
  RGB color = ledColor(pingTravelTimeX());
  analogWrite(redPin, int(color.red));
  analogWrite(greenPin, int(color.green));
  analogWrite(bluePin, int(color.blue));
}

void setup() {
  Serial.begin(9600);

  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(rightWheel, OUTPUT);
  pinMode(leftWheel, OUTPUT);

  for(int i = 0; i < tamArreglo; i++) { // El arreglo de tiempos comienza con un valor medio
    pingTravelTime[i] = 3000;
  }
}

void loop() {
  if(Serial.available()) { // Recibimos la señal bluetooth y la manejamos a nuestro gusto
    input = Serial.read();
    if(input == 'a') {
      go();
    }
    else if(input == 'b') {
      stop();
    }
    else if(input == 'c') {
      turnRight();
    }
    else if(input == 'd') {
      turnLeft();
    }
  }

  for(int i = tamArreglo - 1; i > 0 ; i--) {  // Acomodamos el arreglo de los tiempos eliminando el ultimo
    pingTravelTime[i] = pingTravelTime[i-1];;
  }

  revisarDistancia(); // Agregamos un tiempo más al arreglo
  Serial.println(String(pingTravelTime[0]) + ", X: " + String(pingTravelTimeX())); // Imprimimos en el monitor serial la comparacion entre el ultimo valor y el promedio
  colorearLed(); // Pintamos el led
}
