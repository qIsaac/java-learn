package com.isaac.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:04 2018/10/11
 */
public class CustomClassWriter {

    static String className = "java.lang.Inetger";

    static String cloneableInterface = "java/lang/Cloneable";

    ClassReader reader;

    ClassWriter writer;

    AddFieldAdapter addFieldAdapter;

    public CustomClassWriter() throws IOException {

        reader = new ClassReader(className);

        writer = new ClassWriter(reader, 0);
    }

    public byte[] addField() {
        addFieldAdapter = new AddFieldAdapter(
                "aNewBooleanField",
                org.objectweb.asm.Opcodes.ACC_PUBLIC,
                writer);
        reader.accept(addFieldAdapter, 0);
        return writer.toByteArray();
    }
}
