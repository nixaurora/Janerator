package dev.pixirora.janerator;

import java.util.List;

import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ProtoChunk;

public class GeneratorHolder {
    public ChunkGenerator generator;
    private PlacementVerifier verifier;

    public GeneratorHolder(ChunkGenerator generator, List<List<Integer>> wantedPlacements) {
        this.generator = generator;
        this.verifier = new PlacementVerifier(wantedPlacements);
    }

    public SelectiveProtoChunk getWrappedAccess(ChunkAccess chunk) {
        return new SelectiveProtoChunk((ProtoChunk) chunk, this.verifier);
    }

    public boolean isWanted(int x, int z) {
        return verifier.isWanted(x, z);
    }
}