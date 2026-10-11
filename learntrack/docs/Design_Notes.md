# Design Notes

## Why ArrayList Instead of Array?

LearnTrack stores students, courses, and enrollments in memory. The number of records grows and shrinks while the program runs (add student, add course, enroll, and so on). A fixed-size array would force us to choose a maximum size up front and manually resize when it fills up. `ArrayList` grows automatically, keeps insertion and iteration simple, and fits a console CRUD-style app better than a raw array.

## Where Static Members Are Used and Why

Static members are used in:

- `util.IdGenerator` — static counters and methods (`getNextStudentId()`, `getNextCourseId()`, `getNextEnrollmentId()`) so IDs are unique across the whole application, not per object instance.
- `constants.MenuOptions` and `constants.AppConstants` — static final values shared by the UI without creating constant objects.
- `util.InputValidator` — static helper methods for validation that do not need instance state.

Static is appropriate here because these values/methods belong to the class itself and are shared application-wide.

## Where Inheritance Is Used and What We Gained

Inheritance is used with:

- `Person` as the base class (shared fields: `id`, `firstName`, `lastName`, `email`)
- `Student extends Person`
- `Trainer extends Person` (shows the hierarchy even if trainers are not heavily used in the menu)

We also override `getDisplayName()` in `Student` and `Trainer` for simple polymorphism.

What this gained:

- Common person fields and getters/setters live in one place
- Child classes reuse parent constructors via `super(...)`
- Display behavior can differ by type without duplicating name logic
