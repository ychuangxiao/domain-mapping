/**
 * Copyright (C) 2010-2014 eBusiness Information, Excilys Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.banditcat.android.transformer.compiler.exception;

public class VersionMismatchException extends Exception {

	private static final long serialVersionUID = 1457334941140141471L;

	public VersionMismatchException() {
		super();
	}

	public VersionMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public VersionMismatchException(String message) {
		super(message);
	}

	public VersionMismatchException(Throwable cause) {
		super(cause);
	}

}
