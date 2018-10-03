package zychaowill.algorithm.research;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import zychaowill.algorithm.research.entity.pet.Cat;
import zychaowill.algorithm.research.entity.pet.Dog;
import zychaowill.algorithm.research.entity.pet.Pet;
import zychaowill.algorithm.research.entity.pet.PetType;

public class CatAndDogQueue {
	private Queue<PetWrapper> catQueue;
	private Queue<PetWrapper> dogQueue;
	private long count;

	public CatAndDogQueue() {
		catQueue = new LinkedList<>();
		dogQueue = new LinkedList<>();
	}

	public void add(Pet pet) {
		if (Objects.equals(PetType.DOG, pet.getType())) {
			this.dogQueue.add(new PetWrapper(pet, this.count++));
		} else if (Objects.equals(PetType.CAT, pet.getType())) {
			this.catQueue.add(new PetWrapper(pet, this.count++));
		} else {
			throw new RuntimeException("err, not dog or cat");
		}
	}

	public Pet pollAll() {
		if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
			if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
				return this.dogQueue.poll().getPet();
			} else {
				return this.catQueue.poll().getPet();
			}
		} else if (!this.dogQueue.isEmpty()) {
			return this.dogQueue.poll().getPet();
		} else if (!this.catQueue.isEmpty()) {
			return this.catQueue.poll().getPet();
		} else {
			throw new RuntimeException("err, queue is empty!");
		}
	}

	public Dog pollDog() {
		if (!this.isDogQueueEmpty()) {
			return (Dog) this.dogQueue.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty!");
		}
	}

	public Cat pollCat() {
		if (!this.isCatQueueEmpty()) {
			return (Cat) this.catQueue.poll().getPet();
		} else {
			throw new RuntimeException("Cat queue is empty!");
		}
	}

	public boolean isEmpty() {
		return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
	}

	public boolean isDogQueueEmpty() {
		return this.dogQueue.isEmpty();
	}

	public boolean isCatQueueEmpty() {
		return this.catQueue.isEmpty();
	}

	protected class PetWrapper {
		private Pet pet;
		private long count;

		public PetWrapper(Pet pet, long count) {
			super();
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return this.pet;
		}

		public long getCount() {
			return count;
		}

		public PetType getPetType() {
			return this.pet.getType();
		}
	}
}
