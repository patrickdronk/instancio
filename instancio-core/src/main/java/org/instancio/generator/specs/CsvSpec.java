/*
 * Copyright 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.instancio.generator.specs;

import org.instancio.documentation.ExperimentalApi;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorSpec;
import org.instancio.generator.ValueSpec;

import java.util.function.Predicate;

/**
 * Spec for generating CSV.
 *
 * @since 2.12.0
 */
@ExperimentalApi
public interface CsvSpec extends CsvGeneratorSpec, ValueSpec<String> {

    @Override
    CsvSpec column(String name, Generator<?> generator);

    @Override
    CsvSpec column(String name, GeneratorSpec<?> generatorSpec);

    @Override
    CsvSpec rows(int rows);

    @Override
    CsvSpec rows(int minRows, int maxRows);

    @Override
    CsvSpec noHeader();

    @Override
    CsvSpec wrapWith(String wrapWith);

    @Override
    CsvSpec wrapIf(Predicate<Object> condition);

    @Override
    CsvSpec separator(String separator);

    @Override
    CsvSpec lineSeparator(String lineSeparator);

}
