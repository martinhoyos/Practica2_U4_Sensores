package mx.tecnm.tepic.mghs.practica2_u4_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Bola(l:Lienzo) {
    var lienso = l
    var x = 1080f/2f
    var y = 2200f/2f
    var pinta = Paint()
    var radio = 15
    var apariencia = BitmapFactory.decodeResource(lienso.resources, R.drawable.snowball)

    fun pintar(c: Canvas){
        c.drawBitmap(apariencia,x,y,pinta)
    }

    fun moverbola(xRecibido: Float, yRecibido:Float){
        val dirX = xRecibido
        val dirY = yRecibido

        if(dirY > 1){
            if(y<(2200f-radio-545f)){
                y += 10
            }
        } else if (dirY < -1){
            if(y>-10f){
                y -= 10
            }
        }
        if(dirX < -1){
            if(x<(1080f-radio-215f)){
                x += 10
            }
        } else if(dirX > 1)
        {
            if(x>-10f){
                x -= 10
            }
        }
    }

    fun checarTemperatura(temperatura: Float){
        if(temperatura>=11f){
            apariencia = BitmapFactory.decodeResource(lienso.resources, R.drawable.fireball)
        } else if(temperatura<11f) {
            apariencia = BitmapFactory.decodeResource(lienso.resources, R.drawable.snowball)
        }
    }


}