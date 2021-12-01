package mx.tecnm.tepic.mghs.practica2_u4_sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class Acelerometro(l:Lienzo, b:Bola): SensorEventListener {
    val lienso = l
    var bolita = b
    var sensormanager: SensorManager

    init {
        sensormanager = lienso.context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensormanager.registerListener(this,
        sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
        SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        bolita.moverbola(p0!!.values[0], p0!!.values[1])
        lienso.invalidate()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
}