//package com.example.examplemod;
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.vertex.IVertexBuilder;
//import net.minecraft.client.renderer.entity.model.EntityModel;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//
//public class TorpedoModel extends EntityModel<Torpedo> {
//    private final ModelRenderer bb_main;
//
//    public TorpedoModel() {
//        textureWidth = 64;
//        textureHeight = 64;
//
//        bb_main = new ModelRenderer(this);
//        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
//        bb_main.setTextureOffset(10, 32).addBox(-7.0F, -13.0F, -4.0F, 14.0F, 10.0F, 9.0F, 0.0F, false);
//        bb_main.setTextureOffset(21, 12).addBox(-12.0F, -18.0F, -1.0F, 6.0F, 5.0F, 3.0F, 0.0F, false);
//    }
//
//    @Override
//    public void setRotationAngles(Torpedo entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//        //previously the render function, render code was moved to a method below
//    }
//
//    @Override
//    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
//        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
//    }
//
//    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//        modelRenderer.rotateAngleX = x;
//        modelRenderer.rotateAngleY = y;
//        modelRenderer.rotateAngleZ = z;
//    }
//}