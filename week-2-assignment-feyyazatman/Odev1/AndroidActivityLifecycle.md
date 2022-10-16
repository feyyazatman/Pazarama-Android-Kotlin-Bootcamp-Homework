# Android Activity Lifecycle(Yaşam döngüsü) Nedir? 

Lifecycle’lardan bahsetmeden önce activity’nin ne olduğuna bakalım. Activity temel olarak context sınıfından kalıtım alan bir class’dır. Activity class’lar, Android platformundaki uygulamaların temel bir parçasıdır. Activity, bir uygulamanın kullanıcıyla etkileşimi için giriş noktası görevi görür. Uygulamadaki bir activity, main activity olarak belirtilir. Kullanıcı uygulamayı başlattığında görünen ilk ekran main activity olarak belirttiğimizdir. 

![](Aspose.Words.22b9ead7-5f89-4949-a72f-914bb6203ace.001.png "Screenshot\_1")

Uygulama main() metoduyla başlatıldığında, Android sistemi yaşam döngüsünün belirli aşamalarına karşılık gelen belirli callback metotlarını çağırarak bu işlemleri yapar. Bir activity yaşamı boyunca bir dizi durumdan geçer. Örneğin kullanıcı, uygulamada gezinebilir, uygulamadan çıkabilir veya geri gelebilir. Activity sınıfı, bu durum değişikliklerini callback metotlarıyla bildirir. 

En sık kullanılan callback metotlarından bazıları:

- onCreate() : Bu ilk callback’dir ve sistem aktivitenizi oluşturduğunda tetiklenir.

- onStart() : onCreate() metodundan çıkarken, aktivite “Başlatıldı” durumuna girer ve activity kullanıcıya görünür hale gelir.

- onResume() : Bu, kullanıcı uygulama ile etkileşime girmeye başladığında çağrılır.

- onPause() :  Etkinlik odağı kaybettiğinde ve “Duraklatıldı” durumuna girdiğinde sistem onPause() öğesini çağırır. Duraklatılan activity, kullanıcı girdisi almaz ve herhangi bir kod yürütemez. Örneğin, kullanıcı geri veya son kullanılanlar düğmesine dokunduğunda bu durum oluşur.

- onStop() : Activity artık kullanıcı tarafından görülmediğinde sistem onStop()'u çağırır.

- onRestart() : Bu callback, activity durdurulduktan sonra yeniden başladığında çağrılır. onRestart(), activity durdurulduğu andan itibaren durumunu geri yükler. Bu callback’i her zaman onStart() izler.

- onDestroy() : Sistem, bir activity yok edilmeden önce bu callback’i çağırır. Bu, activity’nin aldığı son callback’dir.

- onBackPressed() : Bu callback, kullanıcının geri tuşa basmasını tespit ettiğinde çağrılır.

- onSaveInstanceState() : Bu callback, bir activity öldürülmeden önce çağrılır. Activity’nin durumunu, kaydetmek için burada alabiliriz. 

- onRestoreInstanceState() : Bu callback, onStart () işleminden sonra çağrılır. Daha önce onSaveInstanceState (Bundle) tarafından kaydedilen herhangi bir görünüm durumunun geri yüklenmesini gerçekleştiririz

- onUserLeaveHint() : Basitçe, kullanıcının uygulamanızdan ayrılmaya çalıştığı hakkında ipuçları verir. Örneğin home tuşuna bastı, back tuşuna bastı gibi. Eğer onUserLeaveHint() kullanıyorsanız, kodunuzda onBackPressed() callback ’ini kullanmanıza gerek kalmaz.




## Android Activity Yaşam Döngüsü Şeması
![](Aspose.Words.22b9ead7-5f89-4949-a72f-914bb6203ace.002.png "activity\_lifecycle")













Ne gibi problemlerle karşı karşıya kalırız? 

- Ekran yatay ve dikey yön arasında döndüğünde kullanıcının ilerlemesinin çökmesi veya kaybolması.

- Kullanıcının uygulamanızdan ayrılıp daha sonra geri dönmesi durumunda ilerlemesini kaybetmek.


Activity, sistem kısıtlamaları nedeniyle yok edildiğinde, ViewModel, onSaveInstanceState() ve/veya local depolama kullanarak kullanıcının geçici UI durumunu korumalısınız. UI verileriniz daha basit ve hafifse bir callback metodu olan onSaveInstanceState() öğesini UI durumunu sürdürmek için tek başına kullanabilirsiniz.

Activity durmaya başladığında, sistem, activity’nin durum bilgilerini bundle olarak kaydedebilmesi için onSaveInstanceState() metodunu çağırır. Bu yöntem default olarak, EditText bileşenindeki metin veya ListView bileşeninin kaydırma konumu gibi geçici bilgileri kaydeder. Ancak daha fazlasını yapmak için onSaveInstanceState() metodunu override etmeniz ve bundle nesnesine key-value çiftlerini eklemeniz gerekir.

Activity yeniden yaratıldığında bundle’daki verilerimizi onCreate() veya onRestoreInstanceState() callback metotları içerisinde ulaşabiliriz.

```kotlin

override fun onSaveInstanceState(outState: Bundle?) {
    // Save the user's current game state
    outState?.run {
       putInt(STATE\_SCORE, currentScore)
       putInt(STATE\_LEVEL, currentLevel)
    }

    // Always call the superclass so it can save the view hierarchy state
   super.onSaveInstanceState(outState)
}

companion object {
  val STATE\_SCORE = "playerScore"
  val STATE\_LEVEL = "playerLevel"
}

```



```kotlin

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState) // Always call the superclass first

    // Check whether we're recreating a previously destroyed instance
    if (savedInstanceState != null) {
       `with(savedInstanceState) {
           // Restore value of members from saved state
           currentScore = getInt(STATE\_SCORE)
           currentLevel = getInt(STATE\_LEVEL)
       }
    } else {
       // Probably initialize members with default values for a new instance
    }
    // ...
}

```

```kotlin
override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
   // Always call the superclass so it can restore the view hierarchy
   super.onRestoreInstanceState(savedInstanceState)

   // Restore state members from saved instance
   savedInstanceState?.run {
      currentScore = getInt(STATE\_SCORE)
      currentLevel = getInt(STATE\_LEVEL)
   }
}

```

## ViewModel 
ViewModel’ in amacı, bir Activity veya Fragment için gerekli olan bilgileri elde etmek ve saklamaktır. ViewModel bunu yaparken genellikle LiveData ve Android Data Binding kullanır. Activity ve Fragment ViewModel’daki değişiklikleri gözlemleyebilir. 

LiveData Observable’ın aksine LifeCycle-Aware’dir. Yani Activity, Fragment gibi bileşenlerin yaşam döngülerine karşılık hareket edebilir. LiveData Observer sınıfından türetilen bir observer’ın aktif yaşam döngüsünde olduğunu varsayar. Lifecycle durumu “Started” veya “Resumed” olduğunda observer’ı güncellemelerden haberdar eder.


