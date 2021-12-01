package mx.tecnm.tepic.mghs.practica2_u4_sensores

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p:MainActivity): View(p) {

    var principal = p
    var bolita = Bola(this)
    var ac = Acelerometro(this,bolita)
    var t = termometro(this,bolita)

    override fun onDraw(c: Canvas){
        super.onDraw(c)

        var p = Paint()

        p.color = Color.CYAN

        c.drawRect(0f,0f,1080f,2200f,p)

        bolita.pintar(c)
    }
}