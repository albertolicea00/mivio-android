# R8 rules for the release build. Hilt, Room, Compose, Media3 and Coil ship their own consumer
# rules; what is here covers reflection R8 cannot see.

# Gson fills the API response classes by field name (no @SerializedName), so their names and
# constructors must survive.
-keep class com.albertolicea00.mivio.data.remote.api.** { <init>(...); <fields>; }

# Gson needs generic signatures to read List<T> fields.
-keepattributes Signature, *Annotation*, InnerClasses, EnclosingMethod
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken

# Retrofit 2.9 reads the service interfaces and suspend return types by reflection
# (rules from Retrofit's own retrofit2.pro, which 2.9 does not bundle for R8 full mode).
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations, AnnotationDefault
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*
