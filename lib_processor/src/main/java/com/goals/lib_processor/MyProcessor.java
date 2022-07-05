package com.goals.lib_processor;

import com.goals.lib_annotation.MyAnnotation;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.goals.lib_annotation.MyAnnotation")
public class MyProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.NOTE,
                "----------my_processor init-----------"
        );
    }

    @Override
    public boolean process(Set<? extends TypeElement> set,
                           RoundEnvironment roundEnvironment) {
        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.NOTE,
                "----------my_processor processing-----------"
        );

        for (Element element:
                roundEnvironment.getElementsAnnotatedWith(MyAnnotation.class)){

            processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.NOTE,
                    "---------------------"
            );

            //判断元素的类型为class
            if (element.getKind() == ElementKind.CLASS){
                //显示转换元素类型
                TypeElement typeElement = (TypeElement) element;
                //输出元素名称
                processingEnv.getMessager().printMessage(
                        Diagnostic.Kind.NOTE,
                        typeElement.getSimpleName()
                );
                //输出元素需要打印的值
                processingEnv.getMessager().printMessage(
                        Diagnostic.Kind.NOTE,
                        typeElement.getAnnotation(MyAnnotation.class).value()
                );
            }

            processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.NOTE,
                    "-----------------------"
            );
        }

        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(MyAnnotation.class.getCanonicalName());

//        return super.getSupportedAnnotationTypes();
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}