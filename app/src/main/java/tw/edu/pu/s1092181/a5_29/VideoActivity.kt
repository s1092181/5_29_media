package tw.edu.pu.s1092181.a5_29

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import tw.edu.pu.s1092181.a5_29.ui.theme._5_29Theme

class VideoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _5_29Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("第二頁")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val link = "https://redirector.googlevideo.com/videoplayback?expire=1716995702&ei=FvJWZo-BK5Pi6dsPxtOckAs&ip=2a01%3A4f8%3A242%3A16d9%3A%3A2&id=o-AMvU1PeiZ1QUtpnyawHEokTI0OA3czMXRGfMc6czHor_&itag=22&source=youtube&requiressl=yes&xpc=EgVo2aDSNQ%3D%3D&mh=b5&mm=31%2C29&mn=sn-4g5edndr%2Csn-4g5lznes&ms=au%2Crdu&mv=m&mvi=1&pl=44&initcwndbps=502500&siu=1&vprv=1&svpuc=1&mime=video%2Fmp4&rqh=1&cnr=14&ratebypass=yes&dur=90.139&lmt=1649032631714477&mt=1716973734&fvip=4&c=ANDROID_TESTSUITE&txp=5532434&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cxpc%2Csiu%2Cvprv%2Csvpuc%2Cmime%2Crqh%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AJfQdSswRQIgdwTEHtXW3VVYPhPYWjSCc5Rx0jqIPKXZQcmeCF0NGyYCIQDJ_FDiBQtK1kRjfMZBRbzGrFKXAcyZo8fZYZ-KbQdAqQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AHWaYeowRQIhAIugbe3uYFE4VEr38Xz9wTOOWAHogy171A5TBcx4PaSjAiBi4kUanMisulrOge5-pgEJMMCNXbaDraj4Wx0IMguhtQ%3D%3D&range=0-3953698&title=X2Download.com-%E3%80%90%E5%85%AC%E5%BC%8F%E3%80%91%E3%80%8E%E3%81%A1%E3%81%84%E3%81%8B%E3%82%8F%E3%80%8F%E7%AC%AC1%E8%A9%B1%E3%80%8C%E3%81%8B%E3%81%9F%E3%82%81%E3%81%AE%E3%83%97%E3%83%AA%E3%83%B3%EF%BC%8F%E3%83%9B%E3%83%83%E3%83%88%E3%82%B1%E3%83%BC%E3%82%AD%E3%80%8D"
    val exoPlayer = ExoPlayer.Builder(context).build()

    val mediaItem = MediaItem.fromUri(android.net.Uri.parse(link))
    exoPlayer.setMediaItem(mediaItem)

    val playerView = PlayerView(context)
    playerView.player = exoPlayer
    DisposableEffect(AndroidView(factory = {playerView})){
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true

        onDispose{
            exoPlayer.release()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    _5_29Theme {
        Greeting2("Android")
    }
}