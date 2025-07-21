package com.skniro.skniro_furniture.entity.furniture;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.joml.Vector3f;

public class CushionEntity extends Entity {
    public CushionEntity(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected Vector3f getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scaleFactor)
    {
        return new Vector3f(0F, dimensions.height * 0.50F * scaleFactor, 0F);
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {

    }

    @Override
    public void kill(){
        this.remove(Entity.RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.kill();
    }
}