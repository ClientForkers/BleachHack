/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package bleach.hack.util;

import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import net.minecraft.entity.Entity;
import net.minecraft.util.Formatting;

public class FriendManager {

	private Set<String> friends = new TreeSet<String>();

	public FriendManager() {
	}

	public FriendManager(Collection<String> names) {
		friends.addAll(names);
	}
	
	public void add(Entity entity) {
		add(entity.getName().getString());
	}

	public void add(String name) {
		for (Formatting f : Formatting.values()) {
			name = name.replace(f.toString(), "");
		}

		if (!name.isEmpty()) {
			friends.add(name.toLowerCase(Locale.ENGLISH));
		}
	}

	public void addAll(Collection<String> names) {
		names.forEach(this::add);
	}
	
	public void remove(Entity entity) {
		remove(entity.getName().getString());
	}

	public void remove(String name) {
		for (Formatting f : Formatting.values()) {
			name = name.replace(f.toString(), "");
		}

		if (!name.isEmpty()) {
			friends.remove(name.toLowerCase(Locale.ENGLISH));
		}
	}

	public void removeAll(Collection<String> names) {
		names.forEach(this::remove);
	}
	
	public boolean has(Entity entity) {
		return has(entity.getName().getString());
	}

	public boolean has(String name) {
		for (Formatting f : Formatting.values()) {
			name = name.replace(f.toString(), "");
		}

		if (!name.isEmpty()) {
			return friends.contains(name.toLowerCase(Locale.ENGLISH));
		}

		return false;
	}

	public Set<String> getFriends() {
		return friends;
	}
}
