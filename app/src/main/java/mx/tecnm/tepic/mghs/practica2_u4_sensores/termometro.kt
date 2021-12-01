package mx.tecnm.tepic.mghs.practica2_u4_sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class termometro(l:Lienzo, b:Bola): SensorEventListener {
    var lienso = l
    var bolita = b
    var sensormanager: SensorManager

    init{
        sensormanager = lienso.principal.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensormanager.registerListener(this,
            sensormanager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
            SensorManager.SENSOR_DELAY_FASTEST)
    }
    override fun onSensorChanged(p0: SensorEvent?) {
        bolita.checarTemperatura(p0!!.values[0])
        lienso.invalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}