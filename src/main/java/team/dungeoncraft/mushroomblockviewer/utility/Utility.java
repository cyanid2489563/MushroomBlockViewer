package team.dungeoncraft.mushroomblockviewer.utility;

import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.Set;

public final class Utility {

    public static Boolean[] getFacingById(int id) {
        Boolean[] faces;

        switch (id) {
            //                               DOWN   EAST   NORTH  SOUTH  UP     WEST
            // BROWN_MUSHROOM_BLOCK
            case   1: faces = new Boolean[]{ false, false, false, false, false, true  }; break;
            case   2: faces = new Boolean[]{ false, false, false, true , false, false }; break;
            case   3: faces = new Boolean[]{ false, false, false, true , false, true  }; break;
            case   4: faces = new Boolean[]{ false, false, true , false, false, false }; break;
            case   5: faces = new Boolean[]{ false, false, true , false, false, true  }; break;
            case   6: faces = new Boolean[]{ false, false, true , true , false, false }; break;
            case   7: faces = new Boolean[]{ false, false, true , true , false, true  }; break;
            case   8: faces = new Boolean[]{ false, false, true , true , true , false }; break;
            case   9: faces = new Boolean[]{ false, false, true , true , true , true  }; break;
            case  10: faces = new Boolean[]{ false, true , false, false, false, false }; break;
            case  11: faces = new Boolean[]{ false, true , false, false, false, true  }; break;
            case  12: faces = new Boolean[]{ false, true , false, false, true , true  }; break;
            case  13: faces = new Boolean[]{ false, true , false, true , false, false }; break;
            case  14: faces = new Boolean[]{ false, true , false, true , false, true  }; break;
            case  15: faces = new Boolean[]{ false, true , false, true , true , true  }; break;
            case  16: faces = new Boolean[]{ false, true , true , false, false, false }; break;
            case  17: faces = new Boolean[]{ false, true , true , false, false, true  }; break;
            case  18: faces = new Boolean[]{ false, true , true , false, true , true  }; break;
            case  19: faces = new Boolean[]{ false, true , true , true , false, false }; break;
            case  20: faces = new Boolean[]{ false, true , true , true , false, true  }; break;
            case  21: faces = new Boolean[]{ false, true , true , true , true , false }; break;
            case  22: faces = new Boolean[]{ false, true , true , true , true , true  }; break;
            case  23: faces = new Boolean[]{ true , false, false, false, false, false }; break;
            case  24: faces = new Boolean[]{ true , false, false, false, false, true  }; break;
            case  25: faces = new Boolean[]{ true , false, false, false, true , false }; break;
            case  26: faces = new Boolean[]{ true , false, false, false, true , true  }; break;
            case  27: faces = new Boolean[]{ true , false, false, true , false, false }; break;
            case  28: faces = new Boolean[]{ true , false, false, true , false, true  }; break;
            case  29: faces = new Boolean[]{ true , false, false, true , true , false }; break;
            case  30: faces = new Boolean[]{ true , false, false, true , true , true  }; break;
            case  31: faces = new Boolean[]{ true , false, true , false, false, false }; break;
            case  32: faces = new Boolean[]{ true , false, true , false, false, true  }; break;
            case  33: faces = new Boolean[]{ true , false, true , false, true , false }; break;
            case  34: faces = new Boolean[]{ true , false, true , false, true , true  }; break;
            case  35: faces = new Boolean[]{ true , false, true , true , false, false }; break;
            case  36: faces = new Boolean[]{ true , false, true , true , false, true  }; break;
            case  37: faces = new Boolean[]{ true , false, true , true , true , false }; break;
            case  38: faces = new Boolean[]{ true , false, true , true , true , true  }; break;
            case  39: faces = new Boolean[]{ true , true , false, false, false, false }; break;
            case  40: faces = new Boolean[]{ true , true , false, false, false, true  }; break;
            case  41: faces = new Boolean[]{ true , true , false, false, true , false }; break;
            case  42: faces = new Boolean[]{ true , true , false, false, true , true  }; break;
            case  43: faces = new Boolean[]{ true , true , false, true , false, false }; break;
            case  44: faces = new Boolean[]{ true , true , false, true , false, true  }; break;
            case  45: faces = new Boolean[]{ true , true , false, true , true , false }; break;
            case  46: faces = new Boolean[]{ true , true , false, true , true , true  }; break;
            case  47: faces = new Boolean[]{ true , true , true , false, false, false }; break;
            case  48: faces = new Boolean[]{ true , true , true , false, false, true  }; break;
            case  49: faces = new Boolean[]{ true , true , true , false, true , false }; break;
            case  50: faces = new Boolean[]{ true , true , true , false, true , true  }; break;
            case  51: faces = new Boolean[]{ true , true , true , true , false, false }; break;
            case  52: faces = new Boolean[]{ true , true , true , true , false, true  }; break;
            case  53: faces = new Boolean[]{ true , true , true , true , true , false }; break;
            // RED_MUSHROOM_BLOCK
            // ERROR on case 54
            //case  54: faces = new Boolean[]{ false, false, false, false, true , false }; break;
            case  55: faces = new Boolean[]{ false, false, true , true , false, false }; break;
            case  56: faces = new Boolean[]{ false, false, true , true , false, true  }; break;
            case  57: faces = new Boolean[]{ false, false, true , true , true , false }; break;
            case  58: faces = new Boolean[]{ false, false, true , true , true , true  }; break;
            case  59: faces = new Boolean[]{ false, true , false, false, false, true  }; break;
            case  60: faces = new Boolean[]{ false, true , false, false, true , true  }; break;
            case  61: faces = new Boolean[]{ false, true , false, true , false, true  }; break;
            case  62: faces = new Boolean[]{ false, true , false, true , true , true  }; break;
            case  63: faces = new Boolean[]{ false, true , true , false, false, true  }; break;
            case  64: faces = new Boolean[]{ false, true , true , false, true , true  }; break;
            case  65: faces = new Boolean[]{ false, true , true , true , false, false }; break;
            case  66: faces = new Boolean[]{ false, true , true , true , false, true  }; break;
            case  67: faces = new Boolean[]{ false, true , true , true , true , false }; break;
            case  68: faces = new Boolean[]{ false, true , true , true , true , true  }; break;
            case  69: faces = new Boolean[]{ true , false, false, false, false, false }; break;
            case  70: faces = new Boolean[]{ true , false, false, false, false, true  }; break;
            case  71: faces = new Boolean[]{ true , false, false, false, true , false }; break;
            case  72: faces = new Boolean[]{ true , false, false, false, true , true  }; break;
            case  73: faces = new Boolean[]{ true , false, false, true , false, false }; break;
            case  74: faces = new Boolean[]{ true , false, false, true , false, true  }; break;
            case  75: faces = new Boolean[]{ true , false, false, true , true , false }; break;
            case  76: faces = new Boolean[]{ true , false, false, true , true , true  }; break;
            case  77: faces = new Boolean[]{ true , false, true , false, false, false }; break;
            case  78: faces = new Boolean[]{ true , false, true , false, false, true  }; break;
            case  79: faces = new Boolean[]{ true , false, true , false, true , false }; break;
            case  80: faces = new Boolean[]{ true , false, true , false, true , true  }; break;
            case  81: faces = new Boolean[]{ true , false, true , true , false, false }; break;
            case  82: faces = new Boolean[]{ true , false, true , true , false, true  }; break;
            case  83: faces = new Boolean[]{ true , false, true , true , true , false }; break;
            case  84: faces = new Boolean[]{ true , false, true , true , true , true  }; break;
            case  85: faces = new Boolean[]{ true , true , false, false, false, false }; break;
            case  86: faces = new Boolean[]{ true , true , false, false, false, true  }; break;
            case  87: faces = new Boolean[]{ true , true , false, false, true , false }; break;
            case  88: faces = new Boolean[]{ true , true , false, false, true , true  }; break;
            case  89: faces = new Boolean[]{ true , true , false, true , false, false }; break;
            case  90: faces = new Boolean[]{ true , true , false, true , false, true  }; break;
            case  91: faces = new Boolean[]{ true , true , false, true , true , false }; break;
            case  92: faces = new Boolean[]{ true , true , false, true , true , true  }; break;
            case  93: faces = new Boolean[]{ true , true , true , false, false, false }; break;
            case  94: faces = new Boolean[]{ true , true , true , false, false, true  }; break;
            case  95: faces = new Boolean[]{ true , true , true , false, true , false }; break;
            case  96: faces = new Boolean[]{ true , true , true , false, true , true  }; break;
            case  97: faces = new Boolean[]{ true , true , true , true , false, false }; break;
            case  98: faces = new Boolean[]{ true , true , true , true , false, true  }; break;
            case  99: faces = new Boolean[]{ true , true , true , true , true , false }; break;
            // MUSHROOM_STEM
            case 100: faces = new Boolean[]{ false, false, false, false, false, true  }; break;
            case 101: faces = new Boolean[]{ false, false, false, false, true , false }; break;
            case 102: faces = new Boolean[]{ false, false, false, false, true , true  }; break;
            case 103: faces = new Boolean[]{ false, false, false, true , false, false }; break;
            case 104: faces = new Boolean[]{ false, false, false, true , false, true  }; break;
            case 105: faces = new Boolean[]{ false, false, false, true , true , false }; break;
            case 106: faces = new Boolean[]{ false, false, false, true , true , true  }; break;
            case 107: faces = new Boolean[]{ false, false, true , false, false, false }; break;
            case 108: faces = new Boolean[]{ false, false, true , false, false, true  }; break;
            case 109: faces = new Boolean[]{ false, false, true , false, true , false }; break;
            case 110: faces = new Boolean[]{ false, false, true , false, true , true  }; break;
            case 111: faces = new Boolean[]{ false, false, true , true , false, false }; break;
            case 112: faces = new Boolean[]{ false, false, true , true , false, true  }; break;
            case 113: faces = new Boolean[]{ false, false, true , true , true , false }; break;
            case 114: faces = new Boolean[]{ false, false, true , true , true , true  }; break;
            case 115: faces = new Boolean[]{ false, true , false, false, false, false }; break;
            case 116: faces = new Boolean[]{ false, true , false, false, false, true  }; break;
            case 117: faces = new Boolean[]{ false, true , false, false, true , false }; break;
            case 118: faces = new Boolean[]{ false, true , false, false, true , true  }; break;
            case 119: faces = new Boolean[]{ false, true , false, true , false, false }; break;
            case 120: faces = new Boolean[]{ false, true , false, true , false, true  }; break;
            case 121: faces = new Boolean[]{ false, true , false, true , true , false }; break;
            case 122: faces = new Boolean[]{ false, true , false, true , true , true  }; break;
            case 123: faces = new Boolean[]{ false, true , true , false, false, false }; break;
            case 124: faces = new Boolean[]{ false, true , true , false, false, true  }; break;
            case 125: faces = new Boolean[]{ false, true , true , false, true , false }; break;
            case 126: faces = new Boolean[]{ false, true , true , false, true , true  }; break;
            case 127: faces = new Boolean[]{ false, true , true , true , false, false }; break;
            case 128: faces = new Boolean[]{ false, true , true , true , true , false }; break;
            case 129: faces = new Boolean[]{ false, true , true , true , true , true  }; break;
            case 130: faces = new Boolean[]{ true , false, false, false, false, false }; break;
            case 131: faces = new Boolean[]{ true , false, false, false, false, true  }; break;
            case 132: faces = new Boolean[]{ true , false, false, false, true , false }; break;
            case 133: faces = new Boolean[]{ true , false, false, false, true , true  }; break;
            case 134: faces = new Boolean[]{ true , false, false, true , false, false }; break;
            case 135: faces = new Boolean[]{ true , false, false, true , false, true  }; break;
            case 136: faces = new Boolean[]{ true , false, false, true , true , false }; break;
            case 137: faces = new Boolean[]{ true , false, false, true , true , true  }; break;
            case 138: faces = new Boolean[]{ true , false, true , false, false, false }; break;
            case 139: faces = new Boolean[]{ true , false, true , false, false, true  }; break;
            case 140: faces = new Boolean[]{ true , false, true , false, true , false }; break;
            case 141: faces = new Boolean[]{ true , false, true , false, true , true  }; break;
            case 142: faces = new Boolean[]{ true , false, true , true , false, false }; break;
            case 143: faces = new Boolean[]{ true , false, true , true , false, true  }; break;
            case 144: faces = new Boolean[]{ true , false, true , true , true , false }; break;
            case 145: faces = new Boolean[]{ true , false, true , true , true , true  }; break;
            case 146: faces = new Boolean[]{ true , true , false, false, false, false }; break;
            case 147: faces = new Boolean[]{ true , true , false, false, false, true  }; break;
            case 148: faces = new Boolean[]{ true , true , false, false, true , false }; break;
            case 149: faces = new Boolean[]{ true , true , false, false, true , true  }; break;
            case 150: faces = new Boolean[]{ true , true , false, true , false, false }; break;
            case 151: faces = new Boolean[]{ true , true , false, true , false, true  }; break;
            case 152: faces = new Boolean[]{ true , true , false, true , true , false }; break;
            case 153: faces = new Boolean[]{ true , true , false, true , true , true  }; break;
            case 154: faces = new Boolean[]{ true , true , true , false, false, false }; break;
            case 155: faces = new Boolean[]{ true , true , true , false, false, true  }; break;
            case 156: faces = new Boolean[]{ true , true , true , false, true , false }; break;
            case 157: faces = new Boolean[]{ true , true , true , false, true , true  }; break;
            case 158: faces = new Boolean[]{ true , true , true , true , false, false }; break;
            case 159: faces = new Boolean[]{ true , true , true , true , false, true  }; break;
            case 160: faces = new Boolean[]{ true , true , true , true , true , false }; break;
            //case 160: faces = new Boolean[]{ true , true , true , true , true , false }; break;

            default : faces = new Boolean[]{ false, false, false, false, true , false }; break;
        }
        return faces;
    }

    public static int getIdByFacing(Set<BlockFace> faces) {
        // Loop through all 160 possible faces combination
        for (int i = 0; i < 160; i++) {
            Set<BlockFace> contained = new HashSet<>();

            // Loop through all 6 possible faces
            for (int j = 0; j < 6; j++) {
                // Get specified faces's value
                boolean face = getFacingById(i)[j];
                // If this face is enabled
                if (face) {
                    // DOWN   EAST   NORTH  SOUTH  UP     WEST
                    // Add corresponding BlockFace into set
                    switch (j) {
                        case 0:
                            contained.add(BlockFace.DOWN);
                            break;
                        case 1:
                            contained.add(BlockFace.EAST);
                            break;
                        case 2:
                            contained.add(BlockFace.NORTH);
                            break;
                        case 3:
                            contained.add(BlockFace.SOUTH);
                            break;
                        case 4:
                            contained.add(BlockFace.UP);
                            break;
                        case 5:
                            contained.add(BlockFace.WEST);
                            break;
                    }
                }
            }
            if (faces.equals(contained)) return i;
        }
        return -1;
    }
}
