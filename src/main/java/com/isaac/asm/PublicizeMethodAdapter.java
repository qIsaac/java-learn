package com.isaac.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 14:25 2018/10/11
 */
public class PublicizeMethodAdapter extends ClassVisitor {
    public PublicizeMethodAdapter(int api, ClassVisitor cv) {
        super(ASM4, cv);
        this.cv = cv;
    }
    public MethodVisitor visitMethod(
            int access,
            String name,
            String desc,
            String signature,
            String[] exceptions) {
        if (name.equals("toUnsignedString0")) {
            return cv.visitMethod(
                    ACC_PUBLIC + ACC_STATIC,
                    name,
                    desc,
                    signature,
                    exceptions);
        }
        return cv.visitMethod(
                access, name, desc, signature, exceptions);
    }

}
