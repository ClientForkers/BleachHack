/*
 * This file is part of the BleachHack distribution (https://github.com/BleachDrinker420/BleachHack/).
 * Copyright (c) 2021 Bleach and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package bleach.hack.util.io;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.io.Resources;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Utils for the BleachHack Resource Github, used for static assets (like the current version)
 */
public class BleachGithubReader {

	private static URI url = URI.create("https://raw.githubusercontent.com/BleachDrinker420/BH-resources/main/");
	
	public static URI getUrl() {
		return url;
	}

	public static List<String> readFileLines(String path) {
		try {
			return Arrays.asList(Resources.toString(getUrl().resolve(path).toURL(), StandardCharsets.UTF_8).replace("\r", "").split("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}
	
	public static JsonObject readJson(String path) {
		try {
			String s = Resources.toString(getUrl().resolve(path).toURL(), StandardCharsets.UTF_8);
			return new JsonParser().parse(s).getAsJsonObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}