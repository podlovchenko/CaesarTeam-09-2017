package technopark.mechanics.models.part;

import org.jetbrains.annotations.NotNull;

import technopark.mechanics.models.Move;
import technopark.mechanics.models.Snap;

import static technopark.mechanics.Config.KeyDown.NOTHING;


public class MovePart implements GamePart {
    @NotNull
    private Move move;

    public MovePart() {
        this.move = new Move(NOTHING);
    }

    @NotNull
    public Move getMove() {
        return move;
    }

    public void setMove(@NotNull Move move) {
        this.move = move;
    }

    @Override
    public MoveSnap takeSnap() {
        return new MoveSnap(this);
    }

    public static final class MoveSnap implements Snap<MovePart> {

        private final Move move;

        public MoveSnap(MovePart mouse) {
            this.move = mouse.getMove();
        }

        public Move getMouse() {
            return move;
        }
    }
}

