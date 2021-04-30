package freelifer.gradle.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

//
//private val Project.android: AndroidConfig
//    get() {
//        return extensions.run {
//            findByName("android") as AndroidConfig
//        }
//    }
//
//private val Project.mavenrepo: MavenRepo
//    get() {
//        return extensions.run {
//            create<MavenRepo>("mavenrepo", MavenRepo::class.java)
//        }
//    }

/**
 * @author zhukun on 2019-06-28.
 */
class _TinkerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        if (project.plugins.hasPlugin(AppPlugin::class.java)) {
            val android = project.extensions.getByType(AppExtension::class.java)

            android.applicationVariants.all { variant ->
                variant.outputs.all { output ->
                    output.processManifestProvider.get().doLast {
//                        (it as ManifestProcessorTask).manifestOutputDirectory.get().asFile
                        val manifestOutFile = output.processManifestProvider.get().manifestOutputDirectory.get().asFile
                        val manifestFile = File(manifestOutFile, "AndroidManifest.xml")
                        doReplaceContent(project, manifestFile)
                    }
//                    output.processManifest.doLast {
//                        val manifestOutFile = output.processManifest.manifestOutputDirectory.get().asFile
//                        val manifestFile = File(manifestOutFile, "AndroidManifest.xml")
//                        doReplaceContent(project, manifestFile)
//                    }
                }
            }
        }
    }

    private fun doReplaceContent(project: Project, manifestFile: File) {
        val mapping = File(project.projectDir, "mapping.txt")
        println("==>> manifest ${manifestFile.absolutePath} exists ${manifestFile.exists()}")
        println("==>> mapping ${mapping.absolutePath} exists ${mapping.exists()}")
        if (!manifestFile.exists() || !mapping.exists()) {
            println("not found file.")
            return
        }

        var text = manifestFile.readText()
        val mappingList = mapping.readLines()
        mappingList.map {
            it.split("->").map { str -> str.trim().removeSuffix(":") }
        }.forEach {
            println(it)
            if (it.size == 2) {
                text = text.replace(it[0], it[1])
            }
        }
        manifestFile.writeText(text)
        println("change AndroidManifest.xml success.")
    }
}